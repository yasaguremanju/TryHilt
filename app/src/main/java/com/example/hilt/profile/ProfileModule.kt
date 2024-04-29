package com.example.hilt.profile

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class) // Scope our dependencies
abstract class ProfileModule {

    // To be read as — When someone asks for DataRepository, create a DataRepoImpl and return it.
    @Binds
    abstract fun getProfileSource(repo: DataRepoImpl): DataRepository
}