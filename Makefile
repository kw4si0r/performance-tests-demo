# DOCKER ---------------------------------------------------------------------------------------------------------------
docker-service-start:
	sudo service docker start
	sudo service docker status

docker-service-stop:
	sudo service docker stop
	sudo service docker status

docker-service-status:
	sudo service docker status

docker-remove-containers:
	docker container rm -f $(docker ps -a -f status=exited -q)

docker-remove-images:
	docker image prune -a -f

docker-remove-all:
	docker container rm -f $(docker ps -a -f status=exited -q)
	docker image prune -a -f

# ----------------------------------------------------------------------------------------------------------------------





# DEMO 1 - run app by compose ,run verifications, call simple test for 5 iterations ------------------------------------

demo-1-start-all:
	make demo-1-stop-all
	docker compose up --build

demo-1-verification:
	curl -vk "http://localhost:8080/user?user-id=user3@pm.me" -H "Content-Type: application/json" -H "Accept: application/vnd.demo.v2+json"
	@echo "\n\n-------------------------\n"
	curl -vk "http://localhost:9080/actuator/health/liveness"
	@echo "\n\n-------------------------\n"
	curl -vk "http://localhost:9080/actuator/prometheus"

demo-1-test:
	k6 run tests/performance/demo-1.js

demo-1-stop-all:
	docker compose down

# ----------------------------------------------------------------------------------------------------------------------





# DEMO 2 - run app by compose ,call different scenario tests -----------------------------------------------------------

demo-2-start-all:
	make demo-2-stop-all
	docker compose -f tests/performance/demo-2-docker-compose.yml up --build

demo-2-test-1-shared_iter_scenario:
	k6 run tests/performance/demo-2-1-shared_iter_scenario.js

demo-2-test-2-per_vu_scenario:
	k6 run tests/performance/demo-2-2-per_vu_scenario.js

demo-2-test-3-constant_vu_scenario:
	k6 run tests/performance/demo-2-3-constant_vu_scenario.js

demo-2-test-4-ramping_vu_scenario:
	k6 run tests/performance/demo-2-4-ramping_vu_scenario.js

demo-2-test-5-constant_arrival_rate_scenario:
	k6 run tests/performance/demo-2-5-constant_arrival_rate_scenario.js

demo-2-test-6-ramping_arrival_rate_scenario:
	k6 run tests/performance/demo-2-6-ramping_arrival_rate_scenario.js

demo-2-stop-all:
	docker compose -f tests/performance/demo-2-docker-compose.yml down

# ----------------------------------------------------------------------------------------------------------------------





# DEMO 3 - run app by compose , call advanced stack --------------------------------------------------------------------

demo-3-start-all:
	make demo-3-stop-all
	docker compose -f tests/performance/demo-3-docker-compose.yml up app influxdb grafana prometheus --build

demo-3-test:
	docker compose -f tests/performance/demo-3-docker-compose.yml up k6

demo-3-stop-all:
	docker compose -f tests/performance/demo-3-docker-compose.yml down

# ----------------------------------------------------------------------------------------------------------------------





# DEMO 4 - run app by compose ,call advanced stack with java JFR -------------------------------------------------------

demo-4-start-all:
	make demo-4-stop-all
	docker compose -f tests/performance/demo-4-docker-compose.yml up app influxdb grafana prometheus --build

demo-4-test:
	docker compose -f tests/performance/demo-4-docker-compose.yml up k6

demo-4-stop-all:
	docker compose -f tests/performance/demo-4-docker-compose.yml down

# ----------------------------------------------------------------------------------------------------------------------


