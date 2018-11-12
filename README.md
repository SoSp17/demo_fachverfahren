Demo-Fachverfahren
==================
Dieses Projekt dient ausschließlich Demonstrationszwecken. Ein günstiger Einstiegspunkt ist bei lokaler Ausführung [http://localhost:8080](http://localhost:8080)

Allgemeine Hinweise
-------------------
Vor dem Anwendungsstart müssen einige Werte in einer Form bereitgestellt werden, die von Spring-Boot Anwendungen verarbeitet werden können wie beispielsweise Umgebungsvariable, Argumente, Systemparameter oder dateien in form einer application.properties oder application.yml. Für weitere Möglichkeiten siehe [hier](https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#boot-features-external-config).

Die folgende Auflistung zeigt sämtliche mögliche Werte mit Beispielen. 

```
servicekonto.base-url = https://docker-host1:9081
servicekonto.keystore-password = password
servicekonto.fachverfahren = 14
servicekonto.key-store-path = target/test-classes/keystore-service-konto-mock.p12"
servicekonto.trust-store-path = target/test-classes/cacerts.jks
servicekonto.nachrichten.local-part = GovGWAsyncResponse
servicekonto.nachrichten.path = /GovGWAsyncResponse/GovGWAsyncResponse.wsdl
servicekonto.nachrichten.target-namespace-uri = http://tempuri.org
servicekonto.nutzerdaten.local-part = UserDataExtendedWeb
servicekonto.nutzerdaten.path = /HHGWUserData/HHGWUserData.wsdl
servicekonto.nutzerdaten.target-namespace-uri = http://tempuri.org
servicekonto.login-url = http://docker-host1:7080/app.html
```

Entwicklerhinweise
------------------
Für Entwickler wurde eine application-dev.yml zur Verfügung gestellt. Wenn die Anwendung mit dem Parameter spring.profiles.active=dev gestartet wird, werden Werte verwendet, welche standardmäßig gegen eine Instanz des Service-Konto-Mock laufen.

### Docker Image
Zur Erstellung eines Dockerimages genügt es, das Projekt mit dem Profil ```docker``` einmal zu bauen.
