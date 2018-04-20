import { UserService } from './../../services/user.service';
import { User } from './../../model/user';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { SharedService } from '../../services/shared.service';

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.css']
})
export class UserNewComponent implements OnInit {

  @ViewChild('form')
  form: NgForm;

  user = new User('', '', '', '');
  shared: UserService;
  message: {};
  classCss: {};


  constructor(private userService: UserService,  private route: ActivatedRoute) {
    this.shared = SharedService.getInstance();
  }

  ngOnInit() {
  }

}
