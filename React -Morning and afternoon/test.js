// const callasync=()=>{
//     return new Promise((res,rej)=>{
//         setTimeout(()=>{
//             console.log("promise")
//             res('response')
//         },1000);
//     })
// }
// const main=()=>{
//     const fn="manideep"
//     const ln="laxmishetty"
//     // const x=fn+ln;
//     // const y=`${fn} ${ln}`;
//     console.log(fn,ln);
//     callasync()
//     .then((res)=>{
//         console.log(res);
        
//     });
//     console.log("here");
// }
// main()

// main();
// function main1(){
//     const fn="manideep"
//     const ln="laxmishetty"
//     const x=fn+ln;
//     const y=`${fn} ${ln}`;
//     console.log(x,y)
// }
// main1();
// var getName=()=> 'Manideep L'
// console.log(`Through function ${getName()}`)
// const x = {
//     a: 'a',
//     b: 'b',
//     c: 'c',
//     d: 'd',
//     e: 'e',
//     f: 'f',
//     g: 'g',
//   };
  
//   const f2 = (pqr) => {
//     console.log('******');
//     console.log(pqr)
//     y={...x,k:'k'}
//     const nextObj = { ...pqr, g: 'g', h: 'h' ,i:'i'};
//     console.log(nextObj,y);
//   };
  
//   const fun = () => {
//     const { a, b, ...abc } = x;
//     const z=x
//     z.a='b'
//     console.log(x,z);
//     f2(abc);
//   };
  
//   fun();
// function Main(){
//     this.fn="None"
//     const ln="Laxmishetty"
//     this.setName=(name)=>{
//         this.fn=name
//     }
//     this.getName=()=>{
//         console.log(`${this.fn} ${ln}`)
//     }
// }
// let main=new Main()
// main.getName()
// main.setName("Manideep")
// main.getName()
// const callAsync = () => {
//     return new Promise((res, rej) => {
//       setTimeout(() => {
//         res('test');
//       }, 1000);
//     });
//   };
  
//   const printNumber = () => {
//     for (let i = 0; i < 10; i++) {
//       console.log(i);
//     }
//   };
  
//   const main = () => {
//     const fistname = 'samarth';
//     const lastname = 'akundi';
//     console.log(fistname, lastname);
//     callAsync()
//       .then((res) => {
//         console.log(res);
//         printNumber();
//       })
//       .catch((e) => {
//         console.log(e);
//       });
//       console.log("end")
//   };
  
//   main();
const callAsync = () => {
    return new Promise((res, rej) => {
      setTimeout(() => {
        res('test');
      }, 1000);
    });
  };
  
  const printNumber = () => {
    for (let i = 0; i < 10; i++) {
      console.log(i);
    }
  };
  
  const main = async () => {
    const fistname = 'samarth';
    const lastname = 'akundi';
    console.log(fistname, lastname);
    const res = await callAsync();
    console.log(res);
    printNumber();
  };
  
  main();
  console.log('end');