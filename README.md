# opeWeatherMap
Тестовое приложение для получения погоды по выбранному городу, работает при помощи апи https://openweathermap.org/api
архитектура приложения:clean architecture,Single Activity<br />
архиектура презентационного слоя: mvp<br />
для взаимодествия с сетью используется HttpUrlConnector<br />
ассинхронность : asynTask. Данный выбор обусловлен требованиями к тестовому.<br />
Использованные библиотеки помимо стандартных: GSON.<br />
Реализованы unit тесты и ui тесты<br />

из DTO в MODEL специально не стал переносить все данные, связи c их ненадобностью 
сами DTO были созданы при помощи онлайн эдитора.

смена ориентации запращена в манифесте.

большое внимание дизайну уделять не стал, но вполне можно сказать, что отступы и размер текста реализованы по Material Design (:

upd: 22.12.2020
Добавлена model презентационного слоя, была упущена.
