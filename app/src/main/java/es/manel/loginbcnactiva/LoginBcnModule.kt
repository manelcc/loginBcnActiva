package es.manel.loginbcnactiva


import dagger.Binds
import dagger.Module

import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import es.manel.loginbcnactiva.core.storage.SharePersistence
import es.manel.loginbcnactiva.core.storage.SharePersistenceImpl


@Module
@InstallIn(SingletonComponent::class)
abstract class LoginBcnModule {


    @Binds
    abstract fun bindPersistence( userServiceImpl: SharePersistenceImpl):SharePersistence

}