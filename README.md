> **Archived on 2020-02-16**\
> I recently switched jobs away from SAP Commerce development

# Demo Project for hybris gradle plugins

This project shows some usage examples for the SAP (Hybris) Commerce build plugin.
It especially shows how to automatically download the distribution files
from the SAP Support Portal

Check the comments in `build.gradle` for explanations and details.

For details about the used plugins check the [commerce-gradle-plugin wiki](https://github.com/sap-commerce-tools/commerce-gradle-plugin/wiki)

## Setup local environment

1. clone the repository
1. `cp gradle.properties.template gradle.properties`
1. adapt `gradle.properties` as described in the file
1. `./gradlew setupDev`
1. Done!

*Note:* use `gradlew` to execute the task to ensure the correct gradle version

*Disclaimer:* the final package will NOT pass the ypackagevalidator, because
the datahub war file is just a dummy file.

If you want a valid package, set `hcs.datahub = false`

## Interesting things

- All `SupportPortalDownload` tasks execute before `bootstrapPlatform`. (This is
  enforced by the plugin)
- `SupportPortalDownload` caches metadata for every downloaded file to speed up
  subsequent builds
- the `hcs-configuration` folder does not contain folders for every environment,
  but the final package still does. This is because the `common` folder is the
  base for every environment config
- also check out how the various `*.properties` files are merged 
  (check the results in `temp/gradle-build-demo_v1.0.0-SNAPSHOT`)
- the datahub war file has the valid file name in the package
