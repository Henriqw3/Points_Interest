package br.com.xyinc.deviceplatform.services

import br.com.xyinc.deviceplatform.documents.PointOfInterest

interface POIsService {

    fun persistPoint(POIs: PointOfInterest): PointOfInterest

    fun getPointByCoordinate(poiX: Int, poiY: Int): PointOfInterest?

    fun getPointByName(name: String): PointOfInterest?

    fun getAllPoints(): List<PointOfInterest>?

    fun getAdjacentPoints(coordX: Int, coordY: Int): List<PointOfInterest>?

    fun removePoint(poiX: Int, poiY: Int)
}
