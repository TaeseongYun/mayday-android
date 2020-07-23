package com.project.mayday.domain.usecase.base

import com.project.mayday.domain.UseCase

abstract class BaseUseCase<in Params> : UseCase{
   abstract operator fun invoke(data: Params): Any
}