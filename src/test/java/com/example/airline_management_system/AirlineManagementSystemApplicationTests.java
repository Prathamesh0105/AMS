package com.example.airline_management_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class AirlineManagementSystemTests {

	@Autowired
	private MockMvc mockMvc;

	// ✅ 1. Get all flights (Success)
	@Test
	void testGetAllFlights() throws Exception {
		mockMvc.perform(get("/flights"))
				.andExpect(status().isOk());
	}

	// ✅ 2. Get a specific flight by ID (Success)
	@Test
	void testGetFlightById() throws Exception {
		mockMvc.perform(get("/flights/1"))  // Assuming ID 1 exists
				.andExpect(status().isOk());
	}

	// ✅ 3. Get schedule for an existing flight (Success)
	@Test
	void testGetSchedule() throws Exception {
		mockMvc.perform(get("/flights/1/schedules")
						.param("dates", "2024-12-01"))  // Example date
				.andExpect(status().isOk());
	}

	// ✅ 4. Book a ticket (Success)
	@Test
	void testBookTicket() throws Exception {
		String ticketJson = """
        {
            "passengerName": "John Doe",
            "flightId": 1
        }
        """;

		mockMvc.perform(post("/tickets")
						.contentType(MediaType.APPLICATION_JSON)
						.content(ticketJson))
				.andExpect(status().isOk());
	}

	// ✅ 5. Get a specific ticket by ID (Success)
	@Test
	void testGetTicket() throws Exception {
		mockMvc.perform(get("/tickets/1"))  // Assuming ticket ID 1 exists
				.andExpect(status().isOk());
	}

	// ✅ 6. Cancel a ticket (Success)
	@Test
	void testCancelTicket() throws Exception {
		mockMvc.perform(delete("/tickets/1"))  // Assuming ticket ID 1 exists
				.andExpect(status().isOk());
	}

	// ✅ 7. Get all flights with sorting
	@Test
	void testGetAllFlightsSorted() throws Exception {
		mockMvc.perform(get("/flights?sort=desc"))
				.andExpect(status().isOk());
	}

	// ✅ 8. Get schedule without date parameter (should fail gracefully)
	@Test
	void testGetScheduleWithoutDate() throws Exception {
		mockMvc.perform(get("/flights/1/schedules")) // No date param
				.andExpect(status().isBadRequest());
	}

	// ✅ 9. Book a ticket and verify the response structure
	@Test
	void testBookTicketResponse() throws Exception {
		String ticketJson = """
        {
            "passengerName": "Alice Smith",
            "flightId": 1
        }
        """;

		mockMvc.perform(post("/tickets")
						.contentType(MediaType.APPLICATION_JSON)
						.content(ticketJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.passengerName").value("Alice Smith"))
				.andExpect(jsonPath("$.flightId").value(1));
	}
}
