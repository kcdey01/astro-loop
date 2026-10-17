# Third-Party Notices

This project bundles third-party assets distributed under their own licenses.
Those licenses are reproduced here and shipped with the application.

## Exo 2 (font)

- **Files:** `app/src/main/res/font/exo2_regular.ttf`, `app/src/main/res/font/exo2_bold.ttf`
  (and the byte-identical copies in `app/src/main/assets/fonts/`, see below)
- **Copyright:** Copyright 2013 The Exo 2 Project Authors
- **Source:** https://github.com/googlefonts/Exo-2.0 (also https://fonts.google.com/specimen/Exo+2)
- **License:** SIL Open Font License, Version 1.1
- **Full license text:** [`app/src/main/assets/licenses/OFL-Exo2.txt`](app/src/main/assets/licenses/OFL-Exo2.txt)

Used as the primary UI/body font. We ship static `regular` and `bold` instances
generated from the unmodified OFL variable font (named-weight instances, the same
form Google distributes statics in).

## Orbitron (font)

- **Files:** `app/src/main/res/font/orbitron_regular.ttf`, `app/src/main/res/font/orbitron_bold.ttf`
  (and the byte-identical copies in `app/src/main/assets/fonts/`, see below)
- **Copyright:** Copyright 2018 The Orbitron Project Authors
- **Source:** https://github.com/theleagueof/orbitron (also https://fonts.google.com/specimen/Orbitron)
- **License:** SIL Open Font License, Version 1.1
- **Reserved Font Name:** "Orbitron"
- **Full license text:** [`app/src/main/assets/licenses/OFL-Orbitron.txt`](app/src/main/assets/licenses/OFL-Orbitron.txt)

Used for the pause overlay and the Crystal Activated screen. We ship static
`regular` and `bold` named-weight instances of the unmodified outlines and retain
the canonical family name; we do not ship a renamed or redesigned derivative.

## Noto Sans SC (font)

- **Files:** `app/src/main/assets/fonts/noto_sans_sc_regular.ttf`, `app/src/main/assets/fonts/noto_sans_sc_bold.ttf`
- **Copyright:** Copyright 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name "Source"
- **Source:** https://github.com/google/fonts/tree/main/ofl/notosanssc (also https://fonts.google.com/noto/specimen/Noto+Sans+SC)
- **License:** SIL Open Font License, Version 1.1
- **Reserved Font Name:** "Source"
- **Full license text:** [`app/src/main/assets/licenses/OFL-NotoSansSC.txt`](app/src/main/assets/licenses/OFL-NotoSansSC.txt)

Used as the CJK fallback font for the Simplified Chinese localization. We ship
static `regular` and `bold` instances subset to the 1,551 CJK codepoints (plus
Latin and punctuation) that the translation actually uses, which brings each
weight from ~10 MB down to ~520 KB. The subsets are generated from the unmodified
OFL variable font and are named `noto_sans_sc_*`; they do not use the Adobe
Reserved Font Name "Source".

### Why the Latin faces are duplicated in `assets/fonts/`

`Typeface.CustomFallbackBuilder` needs an `android.graphics.fonts.FontFamily`,
and the only way to obtain one from packaged font data is
`Font.Builder(AssetManager, path)` — which requires an **asset** path, not a
resource id. Exo 2 and Orbitron therefore also exist under `assets/fonts/` as
byte-identical copies of the `res/font` originals, and the build sets
`androidResources.noCompress += listOf("ttf", "otf")` so the APK stores them
uncompressed (a deflated asset cannot be memory-mapped by the font engine).

---

The SIL Open Font License applies only to the font files; it does not affect the
license of the rest of this project's source code.
