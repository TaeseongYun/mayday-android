package com.project.mayday.ext

fun String?.trimBlank() = this?.replace(" ", "\u00A0")
