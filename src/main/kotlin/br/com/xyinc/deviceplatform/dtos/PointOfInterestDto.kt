package br.com.xyinc.deviceplatform.dtos

import javax.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Min

data class PointOfInterestDto (

        @get:NotEmpty(message = "Nome do ponto de interesse não pode ser vazio.")
        @get:Length(min = 3, max = 80, message = "Nome deve conter no mínimo 3 letras e no máximo 80.")
        val name: String = "",

        @get:Min(value = 0, message = "Apenas números positivos são aceitos")
        val poi_x: Int,
        @get:Min(value = 0, message = "Apenas números positivos são aceitos")
        val poi_y: Int,

        val id: String? = null
)