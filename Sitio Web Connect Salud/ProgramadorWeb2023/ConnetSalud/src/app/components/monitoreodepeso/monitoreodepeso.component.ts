import { Component } from '@angular/core';

interface BmiCalculator {
  height: number;
  weight: number;
  bmi: number;
}

@Component({
  selector: 'app-monitoreodepeso',
  templateUrl: './monitoreodepeso.component.html',
  styleUrls: ['./monitoreodepeso.component.css']
})

export class MonitoreodepesoComponent {
  bmiCalculator: BmiCalculator = {
    height: 0,
    weight: 0,
    bmi: 0
  };

  bmiCategories = [
    { min: 0, max: 18.4, label: 'Bajo Peso' },
    { min: 18.5, max: 24.9, label: 'Saludable' },
    { min: 25.0, max: 29.9, label: 'Sobrepeso' },
    { min: 30.0, max: null, label: 'Obesidad' }
  ];

  calculateBmi() {
    this.bmiCalculator.bmi = this.bmiCalculator.weight / Math.pow(this.bmiCalculator.height, 2);
  }

  getBmiCategory() {
    const category = this.bmiCategories.find((category) => {
      if (category.max === null) {
        return this.bmiCalculator.bmi >= category.min;
      } else {
        return this.bmiCalculator.bmi >= category.min && this.bmiCalculator.bmi <= category.max;
      }
    });    
    return category ? category.label : 'Unknown';
  }

  constructor() { }
  
  ngOnInit(): void {
  }
}
