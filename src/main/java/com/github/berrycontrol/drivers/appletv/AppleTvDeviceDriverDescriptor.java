/*
 *    Copyright 2024 Thomas Bonk <thomas@meandmymac.de>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.berrycontrol.drivers.appletv;

import com.github.berrycontrol.driver.api.BerryHubDeviceDriverDescriptor;
import com.github.berrycontrol.driver.api.BerryHubDeviceDriverException;
import com.github.berrycontrol.driver.api.StartPairingResult;
import com.github.berrycontrol.drivers.appletv.pojo.AppleTvDeviceInfoResponse;
import com.github.berrycontrol.drivers.appletv.pojo.FinalizePairingRequest;
import com.github.berrycontrol.drivers.appletv.pojo.FinalizePairingResponse;
import com.github.berrycontrol.drivers.appletv.pojo.StartPairingRequest;
import com.github.berrycontrol.drivers.appletv.pojo.StartPairingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class AppleTvDeviceDriverDescriptor extends BerryHubDeviceDriverDescriptor<AppleTvDeviceDriver, AppleTvDeviceInfo,AppleTvDeviceCommand> {
    private final static UUID DRIVER_ID = UUID.fromString("5c24dfaa-cc38-11ee-a506-0242ac120002");
    private final static String DISPLAY_NAME = "AppleTV";
    private final static String DESCRIPTION = "Driver for controlling AppleTV devices";
    protected final RestTemplate restTemplate = new RestTemplate();

    public AppleTvDeviceDriverDescriptor() {
        super(DRIVER_ID, DISPLAY_NAME, DESCRIPTION);
    }

    @Override
    public List<AppleTvDeviceInfo> getDevices() throws BerryHubDeviceDriverException {
        try {
            ResponseEntity<AppleTvDeviceInfoResponse[]> response = restTemplate
                .getForEntity("http://localhost:9090/scan", AppleTvDeviceInfoResponse[].class);

            return Arrays
                .stream(
                    Optional
                        .ofNullable(response.getBody())
                        .orElseGet(() -> new AppleTvDeviceInfoResponse[0]))
                .map(d -> new AppleTvDeviceInfo(d.name, d.identifier))
                .collect(Collectors.toList());
        } catch(Exception e) {
            throw new BerryHubDeviceDriverException("Error while loading devices.", e);
        }
    }

    @Override
    public AuthenticationMethod authenticationMethod() {
        return AuthenticationMethod.PIN;
    }

    @Override
    public boolean requiresPairing() {
        return true;
    }

    @Override
    public StartPairingResult startPairing(AppleTvDeviceInfo deviceInfo, String remoteName) throws BerryHubDeviceDriverException {
        try {
            StartPairingRequest request = new StartPairingRequest(remoteName);
            String url = String.format("http://localhost:9090/start_pairing/%s", deviceInfo.getDeviceId());

            ResponseEntity<StartPairingResponse> response = restTemplate
                .postForEntity(url, request, StartPairingResponse.class);

            StartPairingResponse startPairingResponse = response.getBody();
            return StartPairingResult.create(startPairingResponse.pairingRequest(), startPairingResponse.deviceProvidesPin());
        } catch(Exception e) {
            throw new BerryHubDeviceDriverException("Error while starting paring process.", e);
        }
    }

    @Override
    public boolean finalizePairing(String pairingRequest, String pin, boolean deviceProvidesPin) throws BerryHubDeviceDriverException {
        try {
            FinalizePairingRequest request = new FinalizePairingRequest(pin, true);
            String url = String.format("http://localhost:9090/finalize_pairing/%s", pairingRequest);

            ResponseEntity<FinalizePairingResponse> response = restTemplate
                .postForEntity(url, request, FinalizePairingResponse.class);

            return response.getBody().deviceHasPaired();
        } catch(Exception e) {
            throw new BerryHubDeviceDriverException("Error while starting paring process.", e);
        }
    }

    @Override
    public AppleTvDeviceDriver createDriverInstance(String deviceId) {
        return new AppleTvDeviceDriver(deviceId);
    }
}
