import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Im3wsService} from '../services/im3ws.service';
import {SessionDataService} from '../session-data.service';
import {NGXLogger} from 'ngx-logger';

@Component({
  selector: 'app-dev',
  templateUrl: './dev.component.html',
  styleUrls: ['./dev.component.css']
})

// Used to speed up development
export class DevComponent implements OnInit {

  // projectID = 37;
  // imageID = 198;
  // path = 'villancico-al-smo--sto--al-molino-del-amor';

  projectID = 167;
  imageID = 2103;
  path = 'b-59-850';

  constructor(private im3wsService: Im3wsService, private router: Router,
              private sessionDataService: SessionDataService,
              private logger: NGXLogger) {
    this.logger.warn('¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ DEV!!!!!!!!!!!!!!!!!!!!!!');
    this.im3wsService.authService.login('davidrizo', 'nose').subscribe(
      next => {
        if (next) {
          this.im3wsService.authService.setUser(next);
          this.router.navigate(['/project/' + this.projectID])
            .then(value => {
              this.im3wsService.imageService.getImage$(this.imageID).
              subscribe(serviceImage => {
                this.sessionDataService.currentImageMastersURL
                  = 'http://localhost:8888/muret/' + this.path + '/masters/';
                this.sessionDataService.currentImage = serviceImage;
                this.router.navigate(['/image']);
              });
            });
        } else {
          throw new Error('Cannot authenticate!!!');
        }
      }
    );
  }

  ngOnInit() {
  }

}
