package br.com.xyinc.deviceplatform.repositories

import br.com.xyinc.deviceplatform.documents.PointOfInterest
import org.springframework.data.mongodb.repository.MongoRepository


interface PointsRepositories : MongoRepository<PointOfInterest, String> {
    fun findByName(name: String): PointOfInterest
    fun findByCoordinate(poi_x: Int, poi_y:Int): PointOfInterest
}