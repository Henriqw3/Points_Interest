package br.com.xyinc.deviceplatform.controllers

import br.com.xyinc.deviceplatform.documents.PointOfInterest
import br.com.xyinc.deviceplatform.dtos.PointOfInterestDto
import br.com.xyinc.deviceplatform.response.Response
import br.com.xyinc.deviceplatform.services.POIsService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/interestpoint")
class PointsController (val poisService: POIsService){
    
    @RequestMapping("/addpoints")
    @PostMapping
    fun registerPoint(@Valid @RequestBody pointDto: PointOfInterestDto,
                      result: BindingResult): ResponseEntity<Response<PointOfInterestDto>> {

        val response: Response<PointOfInterestDto> = Response<PointOfInterestDto>()
        validatePoint(pointDto, result)

        if(result.hasErrors()) {
            for(e in result.allErrors) response.erros.add(e.defaultMessage!!)
            return ResponseEntity.badRequest().body(response)
        }

        val point: PointOfInterest = DtoToPoint(pointDto, result)
        poisService.persistPoint(point)
        response.dados = PointToDto(point)

        return ResponseEntity.ok(response)
    }

    @RequestMapping("/listofpoint")
    @GetMapping()
    fun listAllPoints(): ResponseEntity<List<PointOfInterestDto?>> {
        val points: List<PointOfInterest> = poisService.getAllPoints()
        val allpoints: List<PointOfInterestDto?> = points.map { points -> PointToDto(points)}
        return ResponseEntity.ok(allpoints)
    }

    @RequestMapping("/approximatepoints")
    @GetMapping
    fun listPointsProx(@RequestParam x:Int, @RequestParam y:Int, @RequestParam dist:Int)
            : ResponseEntity<List<PointOfInterest>> {

        val closeInterestPoints = poisService.getAdjacentPoints(x, y, dist)
        return ResponseEntity.ok(closeInterestPoints!!)
    }
//######### Extra Functions:

    private fun DtoToPoint(poiDto: PointOfInterestDto, result: BindingResult): PointOfInterest {

        if(poiDto.id != null) {
            val point: PointOfInterest? = poisService.getPointByCoordinate(poiDto.poi_x, poiDto.poi_y)
            if(point == null) result.addError(ObjectError("pointOfInterest",
                    "Ponto de interesse não encontrado."))
        }
        return PointOfInterest(poiDto.name, poiDto.poi_x, poiDto.poi_y, poiDto.id)
    }

    private fun PointToDto(point: PointOfInterest): PointOfInterestDto? =
            PointOfInterestDto(point.name, point.poi_x, point.poi_y, point.id)

    private fun validatePoint(poiDto: PointOfInterestDto, result: BindingResult) {

        if(poiDto.id == null){
            result.addError(ObjectError("pointOfInterest",
                    "The point must have some ID"))
            return
        }
        val point: PointOfInterest? = poisService.getPointByCoordinate(poiDto.poi_x, poiDto.poi_y)
        if(point == null) {
            result.addError(ObjectError("pointOfInterest",
                    "The point not found"));
        }
    }
}
