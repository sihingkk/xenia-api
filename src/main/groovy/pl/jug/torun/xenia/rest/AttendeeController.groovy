package pl.jug.torun.xenia.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.jug.torun.xenia.dao.EventRepository
import pl.jug.torun.xenia.rest.dto.AttendeeResponse
import pl.jug.torun.xenia.rest.dto.EventResponse

/**
 * Created by mephi_000 on 06.09.14.
 */
@RestController
@RequestMapping('/event/{eventId}/attendee')
class AttendeeController {
    
    @Autowired
    EventRepository eventRepository

    @RequestMapping(value = '/{id}', method = RequestMethod.GET, produces = ["application/json"])
    EventResponse getResponse(@PathVariable('eventId') long eventId, @PathVariable('id') long id) {
        return new AttendeeResponse(eventRepository.getOne(eventId).attendees.find{it.id == id})
    }
}
