package com.laas.shoppingsmvvm

import androidx.test.platform.app.InstrumentationRegistry
import com.laas.shoppingsmvvm.data.repository.ProductInfoRepositoryImpl
import com.laas.shoppingsmvvm.di.ShoppingsApp
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun instance_iquals() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val repository = (appContext as ShoppingsApp).getRepositoryImpl

        assertEquals(ProductInfoRepositoryImpl::class.java,repository)
    }
}