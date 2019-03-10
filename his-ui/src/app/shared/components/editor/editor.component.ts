import {
  AfterViewInit,
  Component,
  ElementRef,
  EventEmitter,
  HostBinding,
  HostListener,
  Input,
  OnChanges,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnChanges, AfterViewInit {

  @ViewChild('editableContentElement') editableContentElement: ElementRef;
  @HostBinding('class.edit-mode') editMode = false;
  @Input() content: string;
  @Input() showControls: boolean;
  @Output() saveEditEvent = new EventEmitter<string>();
  @Output() cancelEditEvent = new EventEmitter<never>();

  constructor() {
  }


  ngOnChanges(changes: SimpleChanges): void {
    if (changes.content && this.editableContentElement) {
      this.setEditableContent(this.content);
    }
  }

  ngAfterViewInit(): void {
    this.setEditableContent(this.content);
  }

  @HostListener('click')
  focusEditableContent() {
    if (this.editMode) {
      this.editableContentElement.nativeElement.focus();
    }
  }

  saveEdit(){
    this.editMode=false;
    this.saveEditEvent.emit(this.getEditableContent());
  }

  cancelEdit(){
    this.editMode=false;
    this.setEditableContent(this.content);
    this.cancelEditEvent.emit();
  }

  beginEdit(){
    this.editMode=true;
  }


  private setEditableContent(content: string) {
    this.editableContentElement.nativeElement.textContent = content;
  }

  private getEditableContent() {
    return this.editableContentElement.nativeElement.textContent;
  }
}
