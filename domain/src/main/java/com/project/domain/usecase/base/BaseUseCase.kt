package com.project.domain.usecase.base

import com.project.domain.UseCase

abstract class BaseUseCase<in Params> : UseCase {
   abstract operator fun invoke(data: Params): Any
}