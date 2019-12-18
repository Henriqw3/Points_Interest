package br.com.xyinc.deviceplatform.documents

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

@Document
data class PointOfInterest (
        val name: String,
        val poi_x: Int,
        val poi_y: Int,
        @Id val id: String? = null
)