import requests
city = "Kuz’minki, RU"
appid = "1c120e8db884c1e24eabe2a8020b4cae"
res = requests.get("http://api.openweathermap.org/data/2.5/weather",
                   params={'q': city, 'units': 'metric', 'lang': 'ru', 'APPID': appid})
data = res.json()
print("Город:", city)
print("Погодные условия:", data['weather'][0]['description'])
print("Cкорость ветра:", data['wind']['speed'])
print("Видимость", data['visibility'])