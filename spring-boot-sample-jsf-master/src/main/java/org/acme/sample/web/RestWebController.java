package org.acme.sample.web;

import java.util.List;

import org.acme.sample.bean.Event;
import org.acme.sample.bean.EventForm;
import org.acme.sample.repository.TodoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RestWebController {
	@Autowired
	TodoRepositoryImpl todoRepository;
	@RequestMapping(value="/get-events", method = RequestMethod.POST)
	public ResponseEntity<?> buscarEventos(@ModelAttribute EventForm form,Model model){
		List<Event> events = todoRepository.buscarComicsCalendario(form.getUserid(), form.getStart(), form.getEnd());
		return ResponseEntity.ok(events);
	}
}
