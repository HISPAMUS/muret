import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { NewUser } from '../../models/newusermodel';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newuserModel : NewUser = {}

  constructor() 
  { 
  }

  ngOnInit() {
  }

  startRegister()
  {
    console.log(this.newuserModel)
  }

  generateRandomPWD()
  {
    event.preventDefault()
    let randompwd = Math.random().toString(36);
    this.newuserModel.password = randompwd
  }

}
