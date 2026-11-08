# AOSPShade

An experimental LSPosed module project exploring an AOSP-style notification shade and Quick Settings experience on Samsung One UI.

## Project status

**Early prototype / scaffold.** The repository is being prepared for Galaxy S25 (SM-S931N), One UI 9, Android 17, and LSPosed.

The initial build will verify the Android project structure and LSPosed entry-point loading. It does **not** yet replace Samsung SystemUI's notification shade or Quick Settings. Full shade replacement requires device-specific SystemUI analysis, carefully scoped hooks, and on-device testing.

## Safety

- Do not flash unverified ZIPs or modify SystemUI framework files blindly.
- Keep a way to disable the LSPosed module and recover if SystemUI crashes.
- Test changes incrementally and keep a backup.

## Planned milestones

1. Create a buildable LSPosed module scaffold.
2. Add a GitHub Actions workflow to build and publish APK artifacts.
3. Inspect One UI 9 SystemUI behavior and identify compatible hook points.
4. Implement and test AOSP-style notification shade and Quick Settings changes.

## Target environment

- Device: Samsung Galaxy S25 (SM-S931N)
- OS: One UI 9 / Android 17 (API 37)
- Framework: LSPosed
