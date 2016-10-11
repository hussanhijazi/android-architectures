package br.com.hussan.githubapi.data.api

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Qualifier

@Qualifier
@Retention(RUNTIME)
annotation class ApiUrl
