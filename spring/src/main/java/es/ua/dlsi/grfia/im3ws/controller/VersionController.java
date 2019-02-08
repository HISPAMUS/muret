package es.ua.dlsi.grfia.im3ws.controller;

import es.ua.dlsi.grfia.im3ws.entity.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author drizo
 */
@Controller
public class VersionController {
    @GetMapping("/version")
    @ResponseBody
    public Version getVersion() {
        return new Version();
    }
}
