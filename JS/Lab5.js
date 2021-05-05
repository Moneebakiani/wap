//  Question 1

let arr = [
    1,
    50,
    40,
    3,
    10
    ];
    let sum=arr.filter(x=>x>20).reduce((accum,current)=>accum+current,0);
    console.log(sum);

    
    // Question 2

    let arr = [
        'Moneeba',
        'Ambassa',
        'John',
        'yaya',
        'kashif'
        ];
        let str=arr.filter(x=>x.length>5).filter(y=>y.includes('a'));
        console.log(str);

        
        // Question 3

        function Employee(firstname, lastname,datebirth){
            this.firstname=firstname;
            this.lastname=lastname;
            this.datebirth=datebirth;
            this.getFullName=function(){
              return this.firstname+' '+this.lastname;
            }
            this.getAge=function()
            {
               return new Date().getFullYear() - this.datebirth.getFullYear();
            }
            
            }
            const john=new Employee('John','Smith', new Date("03/25/1994"));
            const moni=new Employee('Moneeba','Kiani', new Date("03/25/2016"));
            let a=[
            john,
            moni
            ];
            let res1=a.filter(e=>e.getAge()>20).map(x=>x.getFullName());
            console.log('Employee age greater than 20: '+res1);
            let res2=a.filter(e=>e.datebirth.getFullYear()>2000).map(x=>x.getFullName());
            console.log('Employee born after 2000: '+res2);