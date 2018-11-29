import requests

# 1. POST Travel Agent
print('[[ 1. POST Travel Agent ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/travel-agent',
                        json={"firstName": "Ben", "lastName": "Smith", "phoneNumber": "2131209321"})
print(request)
response = request.json()
print(response)
travel_agent_id = response.get("person_id")
print(travel_agent_id)

# 2. POST Trip
print('[[ 2. POST Trip')
request = requests.post('http://localhost:8080/premium-travel-backend/trip',
                        json={"travel-agent-id": travel_agent_id})
print(request)
response = request.json()
print(response)
trip_id = response.get("trip-id")
print(trip_id)

# 3. POST Traveller
print('[[ 3. POST Traveller ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/traveller',
                        json={"firstName": "Jeff",
                              "lastName": "Dunham",
                              "phoneNumber": "2131209321"})
print(request)
response = request.json()
print(response)
traveller_id = response.get("person_id")
print(traveller_id)

# 4. PUT Traveller on Trip
print('[[ 4. PUT Traveller on Trip ]]')
request = requests.put('http://localhost:8080/premium-travel-backend/trip/' + trip_id,
                       json={"traveller-id": traveller_id})
print(request)

# 5. Complete ADD_TRAVELLERS State
print('[[ 5. Complete ADD_TRAVELLERS State')
request = requests.post('http://localhost:8080/premium-travel-backend/trip/' + trip_id)
print(request)

# 6. Add Package to Trip
print('[[ 6. Add Package to Trip ]]')
request = requests.get('http://localhost:8080/premium-travel-backend/package')
print(request)
response = request.json()
print(response)
package = response[1]
print(package)
package_id = package.get('packageID')
print(package_id)

request = requests.put('http://localhost:8080/premium-travel-backend/trip/' + trip_id,
                       json={"package-id": package_id, "departure-date": "reewrwdfs", "arrival-date": "fdsfdf"})
print(request)

# 7. Complete ADD_PACKAGES State
print('[[ 7. Complete ADD_PACKAGES State ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/trip/' + trip_id)
print(request)

# 8a. Payment Type - Cash
print('[[ 8a. Payment Type - Cash ]]')
request = requests.put('http://localhost:8080/premium-travel-backend/trip/' + trip_id, json={"payment-type": "Cash"})
print(request)

# 9. Complete SELECT_PAYMENT_TYPE State
print('[[ 9. Complete SELECT_PAYMENT_TYPE State ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/trip/' + trip_id)
print(request)

# 10. Get Bill
print('[[ 10. Get Bill ]]')
request = requests.get('http://localhost:8080/premium-travel-backend/trip/' + trip_id + '/bill')
print(request)
response = request.json()
print(response)

request = requests.get('http://localhost:8080/premium-travel-backend/trip/' + trip_id + '/bill/amount')
print(request)
amount = request.json()
print(amount)

# 11a. Payment - Cash
print('[[ 11a. Payment - Cash ]]')
request = requests.put('http://localhost:8080/premium-travel-backend/trip/' + trip_id,
                       json={'person-id': traveller_id, 'amount': amount})
print(request)

# 12. Complete SELECT_PAYMENT_TYPE State
print('[[ 12. Complete PAYMENT State ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/trip/' + trip_id)
print(request)

# 13. Attach Thank You Note
print('[[ 13. Attach Thank You Note ]]')
request = requests.put('http://localhost:8080/premium-travel-backend/trip/' + trip_id,
                       json={'thank-you-note': 'Thank you very much for your business.'})
print(request)

# 14. Complete THANK_YOU State
print('[[ 14. Complete THANK_YOU State ]]')
request = requests.post('http://localhost:8080/premium-travel-backend/trip/' + trip_id)
print(request)

# 15. Show itinerary
print('[[ 15. Show itinerary ]]')
request = requests.get('http://localhost:8080/premium-travel-backend/trip/' + trip_id + '/itinerary')
print(request)
response = request.json()
print(response)
