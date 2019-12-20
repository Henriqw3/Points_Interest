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
@RequestMapping("/pointofinterest")
class PointsController (val poisService: POIsService){

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

        return ResponseEntity.ok(response)
    }

    private fun DtoToPoint(poiDto: PointOfInterestDto, result: BindingResult): PointOfInterest {

        if(poiDto.id != null) {
            val point: PointOfInterest? = poisService.
        }
    }

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