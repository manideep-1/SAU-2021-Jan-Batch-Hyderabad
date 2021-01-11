//higher order function
var intArr = [1, 2, 3, 4, 5];
function customReduce(arr, fn){
    let last=0;
    for(var i=0; i<arr.length; i++) {        
        last = fn(last,arr[i]);   
        console.log(last) 
    }    
    return last;
}

console.log(customReduce(intArr,(acc,cur)=> acc + cur));
// inta=[1,2,3,4]
// var a=inta.map((i)=>(i*2))
// console.log(a)
// function mapf(inta)
// {

// }
// inta=[1,2,3,4]
// var a=inta.mapf()
// var intArr = [1, 2, 3, 4, 5];

// function cusmap(arr, mapfn){
//     const myarr = []; 
//     for(var i=0; i<arr.length; i++) {        
//         const op = mapfn(arr[i]);        
//         myarr.push(op);    
//     }    
//     return myarr;
// }
// var val=intArr.reduce((acc,val)=>{
//     console.log(acc)
//     return acc+val;
// })
// console.log(val)
// console.log(cusmap(intArr,(obj)=> obj * 2));
// function customReduce(arr,fn)
// {
//     let val,sum=0;; 
//     for(var i=0; i<arr.length; i++) {        
//         sum+=arr[i];
//         fn(sum,arr[i]);   
//     }    
//     return sum;
// }
