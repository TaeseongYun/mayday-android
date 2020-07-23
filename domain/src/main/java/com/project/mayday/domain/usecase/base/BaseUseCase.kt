package com.project.mayday.domain.usecase.base

abstract class BaseUseCase<in Params> {
   abstract operator fun invoke(data: Params): Any
}