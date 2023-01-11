package io.github.hydrazinemc.oxidiser

import com.llamalad7.mixinextras.MixinExtrasBootstrap
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.loader.api.entrypoint.PreLaunchEntrypoint

class OxidiserPreLaunchInitializer : PreLaunchEntrypoint {
	override fun onPreLaunch(mod: ModContainer?) {
		MixinExtrasBootstrap.init()
	}
}