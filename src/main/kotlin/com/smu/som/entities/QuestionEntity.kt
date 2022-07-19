package com.smu.som.entities

import com.smu.som.dto.CreateQuestionDTO
import com.smu.som.dto.ReadQuestionDTO
import javax.persistence.*

enum class Target{
	SMStudent, Couple, Married, Family, VariousFamily
}

@Entity
data class QuestionEntity (
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
	@Enumerated(EnumType.STRING)
	val target: Target,
	val category: String,
	val question: String
){
	fun toReadQuestionDTO(): ReadQuestionDTO {
		return ReadQuestionDTO(
			id = id,
			target = target,
			category = category,
			question = question
		)
	}

	fun toCreateQuestionDTO(): CreateQuestionDTO {
		return CreateQuestionDTO(
			target = target,
			category = category,
			question = question
		)
	}
}
