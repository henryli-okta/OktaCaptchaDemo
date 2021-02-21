# OktaCaptchaDemo

Before run the application:
1. Go to /etc/hosts and add a record henrytest.com => 172.0.0.1
2. Open browser and type henrytest.com:8080/

Configuration: properties in `application.properties`
1. To simulate org-wide configuration case, set config.useOrgCaptchaConfig = true
2. To simulate org-wide configuration case: 
  a. set config.useOrgCaptchaConfig = false
  b. set config.appCaptchaConfig.instanceId = 123 # or 456
