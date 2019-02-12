import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {RestClientService} from '../services/rest-client.service';
import {SessionDataService} from '../services/session-data.service';
import {NGXLogger} from 'ngx-logger';
import {AuthService} from "../services/auth.service";
import {ImageService} from "../services/image.service";

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

  constructor(private authService: AuthService, private router: Router,
              private imageService: ImageService,
              private sessionDataService: SessionDataService,
              private logger: NGXLogger) {
    this.logger.warn('¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ DEV!!!!!!!!!!!!!!!!!!!!!!');
    this.authService.login('davidrizo', 'nose').subscribe(
      next => {
        if (next) {
          this.authService.setUser(next);
          this.router.navigate(['/project/' + this.projectID])
            .then(value => {
              this.imageService.getImage$(this.imageID).
              subscribe(serviceImage => {
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
