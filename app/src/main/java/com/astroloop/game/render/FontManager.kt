package com.astroloop.game.render

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Build
import android.util.Log

/**
 * Singleton manager for custom fonts.
 * Body family = Exo 2 (getRegular/getBold), the default for all game text.
 * Display family = Orbitron (getDisplayRegular/getDisplayBold), for the
 * pause overlays (death crystals are wordless).
 * Call initialize() from MainActivity.onCreate() BEFORE any renderer is
 * constructed — renderer Paint fields capture the typeface at construction.
 *
 * Chinese localization: neither Exo 2 nor Orbitron carries CJK glyphs, so every Chinese character
 * would otherwise be drawn as tofu. Noto Sans SC (subset to the glyphs this build uses, ~520 KB per
 * weight, stored uncompressed — see `androidResources.noCompress` in build.gradle.kts) is chained
 * behind each Latin face, so letters and digits keep the original sci-fi look while Chinese is
 * drawn by Noto.
 *
 * The chain lives in [FontChain] rather than here on purpose. `android.graphics.fonts.*` starts at
 * API 26 and `CustomFallbackBuilder` at 29; this class runs on minSdk 24, and a method signature
 * mentioning a class the device does not have is enough to fail verification of the whole class on
 * those releases. Keeping the modern types inside a nested object means only devices that take the
 * modern path ever load it.
 *
 * Below API 29 there is no fallback chain, so those devices get the bundled CJK face directly: a
 * Chinese HUD in a plainer Latin face beats a correct Exo 2 that renders every Chinese character as
 * an empty box.
 */
object FontManager {

    private const val EXO_REGULAR = "fonts/exo2_regular.ttf"
    private const val EXO_BOLD = "fonts/exo2_bold.ttf"
    private const val ORBITRON_REGULAR = "fonts/orbitron_regular.ttf"
    private const val ORBITRON_BOLD = "fonts/orbitron_bold.ttf"
    private const val CJK_REGULAR = "fonts/noto_sans_sc_regular.ttf"
    private const val CJK_BOLD = "fonts/noto_sans_sc_bold.ttf"

    private var bodyRegular: Typeface? = null
    private var bodyBold: Typeface? = null
    private var displayRegular: Typeface? = null
    private var displayBold: Typeface? = null
    private var initialized = false

    fun initialize(context: Context) {
        if (initialized) return
        try {
            val assets = context.assets
            bodyRegular = chain(assets, EXO_REGULAR, CJK_REGULAR)
            bodyBold = chain(assets, EXO_BOLD, CJK_BOLD)
            displayRegular = chain(assets, ORBITRON_REGULAR, CJK_REGULAR)
            displayBold = chain(assets, ORBITRON_BOLD, CJK_BOLD)
            initialized = true
        } catch (e: Exception) {
            // Fallback to monospace if font loading fails. Substituting all four faces is
            // visually obvious but otherwise produces no diagnostic at all — log the cause
            // so a stripped or corrupt font resource is identifiable from a bug report.
            Log.e("FontManager", "Font load failed; falling back to MONOSPACE for all faces", e)
            bodyRegular = Typeface.MONOSPACE
            bodyBold = Typeface.MONOSPACE
            displayRegular = Typeface.MONOSPACE
            displayBold = Typeface.MONOSPACE
            initialized = true
        }
    }

    /**
     * [latin] with [cjk] behind it, so a glyph missing from the Latin face is looked up in the
     * Chinese one instead of disappearing.
     */
    private fun chain(assets: AssetManager, latin: String, cjk: String): Typeface {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            // No fallback chain on these releases: Chinese legibility wins over Latin styling.
            return Typeface.createFromAsset(assets, cjk)
        }
        return FontChain.build(assets, latin, cjk)
    }

    fun getRegular(): Typeface = bodyRegular ?: Typeface.MONOSPACE
    fun getBold(): Typeface = bodyBold ?: Typeface.MONOSPACE
    fun getDisplayRegular(): Typeface = displayRegular ?: Typeface.MONOSPACE
    fun getDisplayBold(): Typeface = displayBold ?: Typeface.MONOSPACE

    /** API 29+ only. Isolated so `android.graphics.fonts` is never resolved on older devices. */
    private object FontChain {

        fun build(assets: AssetManager, latin: String, cjk: String): Typeface {
            val latinFamily = family(assets, latin)
            val cjkFamily = family(assets, cjk)
            return try {
                when {
                    latinFamily != null && cjkFamily != null ->
                        Typeface.CustomFallbackBuilder(latinFamily)
                            .addCustomFallback(cjkFamily)
                            .build()
                    latinFamily != null -> Typeface.CustomFallbackBuilder(latinFamily).build()
                    cjkFamily != null -> Typeface.CustomFallbackBuilder(cjkFamily).build()
                    else -> Typeface.createFromAsset(assets, cjk)
                }
            } catch (e: Exception) {
                Log.w("FontManager", "Font chain failed for $latin; using $cjk alone", e)
                Typeface.createFromAsset(assets, cjk)
            }
        }

        private fun family(assets: AssetManager, path: String): android.graphics.fonts.FontFamily? =
            try {
                android.graphics.fonts.FontFamily.Builder(
                    android.graphics.fonts.Font.Builder(assets, path).build()
                ).build()
            } catch (e: Exception) {
                Log.w("FontManager", "Could not load font asset $path", e)
                null
            }
    }
}
