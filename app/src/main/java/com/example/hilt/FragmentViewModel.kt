package com.example.hilt

import android.content.Context
import android.media.Image.Plane
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.profile.DataRepository
import com.example.hilt.profile.Profile
import com.example.hilt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor(
    private val repo: DataRepository,
    private val stringRepo: Repository<String>,
    @ApplicationContext val applicationContext: Context
) : ViewModel() {

    fun getProfile(): Profile = repo.getProfile()

    fun getString() {
        viewModelScope.launch {

            val packages = applicationContext.packageName
            Timber.d("[getString] package:$packages")

            val deffer1 = async {
                stringRepo.fetch()
            }
            val deffer2 = async {
                stringRepo.get()
            }


            val value1 = runCatching { deffer1.await() }.getOrNull()
            val value2 = runCatching { deffer2.await() }.getOrNull()
            Timber.d("[getString] deffer1:${value1}, deffer2:$value2")

        }
    }


}