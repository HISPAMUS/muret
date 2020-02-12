package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.watchdog.WatchDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// !!! Important: no controller should throw any exception

@RequestMapping("statusControl")
@RestController
public class ServerStatusController
{
    private WatchDog m_statusControl;

    @Autowired
    public ServerStatusController(WatchDog c_watchdog)
    {
        m_statusControl = c_watchdog;
    }

    @GetMapping(path = "getStatus")
    public StringResponse GetServerStatus()
    {
        return new StringResponse(String.valueOf(m_statusControl.GetServerStatus()));
    }
}
