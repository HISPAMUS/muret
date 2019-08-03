package es.ua.dlsi.grfia.im3ws.muret.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @author drizo
 */
//@CrossOrigin("${angular.url}")
@RequestMapping("trainingsets")
@RestController
@Transactional
// this solves the error: "springboot "failed to lazily initialize a collection of role": could not initialize proxy - no Session
public class NotationController {
}
