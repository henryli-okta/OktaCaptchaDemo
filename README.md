# OktaCaptchaDemo

Note: you cannot run this applicaiton directly because I have removed hCaptcha and reCaptcha credentials. You need to add related credentials in `CaptchaInstanceService.java`

Configuration: properties in `application.properties`
1. To simulate org-wide configuration case, set config.useOrgCaptchaConfig = true

2. To simulate org-wide configuration case: 
  a. set config.useOrgCaptchaConfig = false
  b. set config.appCaptchaConfig.enabled = true
  c. set config.appCaptchaConfig.instanceId = 123 # or 456

3. To disable captcha:
  a. set config.useOrgCaptchaConfig = false
  b. set config.appCaptchaConfig.enabled = false
