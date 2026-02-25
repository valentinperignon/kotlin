/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("FunctionName")

package org.jetbrains.kotlin.gradle.unitTests

import org.jetbrains.kotlin.gradle.plugin.mpp.apple.*
import org.jetbrains.kotlin.konan.target.KonanTarget
import kotlin.test.*

class AppleSdkVisionOSTest {

    @Test
    fun `defineNativeTargets - xros arm64 returns VISIONOS_ARM64`() {
        val targets = AppleSdk.defineNativeTargets("xros", listOf("arm64"))
        assertEquals(listOf(KonanTarget.VISIONOS_ARM64), targets)
    }

    @Test
    fun `defineNativeTargets - xros arm64e returns VISIONOS_ARM64`() {
        val targets = AppleSdk.defineNativeTargets("xros", listOf("arm64e"))
        assertEquals(listOf(KonanTarget.VISIONOS_ARM64), targets)
    }

    @Test
    fun `defineNativeTargets - xrsimulator arm64 returns VISIONOS_SIMULATOR_ARM64`() {
        val targets = AppleSdk.defineNativeTargets("xrsimulator", listOf("arm64"))
        assertEquals(listOf(KonanTarget.VISIONOS_SIMULATOR_ARM64), targets)
    }

    @Test
    fun `defineNativeTargets - xrsimulator arm64e returns VISIONOS_SIMULATOR_ARM64`() {
        val targets = AppleSdk.defineNativeTargets("xrsimulator", listOf("arm64e"))
        assertEquals(listOf(KonanTarget.VISIONOS_SIMULATOR_ARM64), targets)
    }

    @Test
    fun `defineNativeTargets - xros unsupported arch throws`() {
        assertFailsWith<IllegalArgumentException> {
            AppleSdk.defineNativeTargets("xros", listOf("x86_64"))
        }
    }

    @Test
    fun `defineNativeTargets - xrsimulator unsupported arch throws`() {
        assertFailsWith<IllegalArgumentException> {
            AppleSdk.defineNativeTargets("xrsimulator", listOf("x86_64"))
        }
    }

    @Test
    fun `appleArchitecture - VISIONOS_ARM64 returns arm64`() {
        assertEquals("arm64", KonanTarget.VISIONOS_ARM64.appleArchitecture)
    }

    @Test
    fun `appleArchitecture - VISIONOS_SIMULATOR_ARM64 returns arm64`() {
        assertEquals("arm64", KonanTarget.VISIONOS_SIMULATOR_ARM64.appleArchitecture)
    }

    @Test
    fun `appleTarget - VISIONOS_ARM64 returns VISIONOS_DEVICE`() {
        assertEquals(AppleTarget.VISIONOS_DEVICE, KonanTarget.VISIONOS_ARM64.appleTarget)
    }

    @Test
    fun `appleTarget - VISIONOS_SIMULATOR_ARM64 returns VISIONOS_SIMULATOR`() {
        assertEquals(AppleTarget.VISIONOS_SIMULATOR, KonanTarget.VISIONOS_SIMULATOR_ARM64.appleTarget)
    }

    @Test
    fun `applePlatform - VISIONOS_DEVICE returns visionOS`() {
        assertEquals("visionOS", AppleTarget.VISIONOS_DEVICE.applePlatform)
    }

    @Test
    fun `applePlatform - VISIONOS_SIMULATOR returns visionOS Simulator`() {
        assertEquals("visionOS Simulator", AppleTarget.VISIONOS_SIMULATOR.applePlatform)
    }

    @Test
    fun `sdk - VISIONOS_DEVICE returns xros`() {
        assertEquals("xros", AppleTarget.VISIONOS_DEVICE.sdk)
    }

    @Test
    fun `sdk - VISIONOS_SIMULATOR returns xrsimulator`() {
        assertEquals("xrsimulator", AppleTarget.VISIONOS_SIMULATOR.sdk)
    }
}
