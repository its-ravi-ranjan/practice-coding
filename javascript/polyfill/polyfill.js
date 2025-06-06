Array.prototype.myFilter = function(callback,strArg){
    let outputs = [];
    for(let i=0;i<this.length;i++){
        if(callback.call(strArg,this[i],i,this))
        outputs.push(this[i])
}
return outputs
}
const arr = [1, 2, 3];
const ans = arr.myFilter(num => num > 1);
console.log(ans)
Array.prototype.mymap =function(callback,thisArg){
    let result = []
    for(let i=0;i<this.length;i++){
        if(i in this)
        result.push(callback.call(thisArg,this[i],i,this))
    }
    return this
}

Array.prototype.myForEach = function(callback,thisArg){
    for(let i=0;i<this.length;i++){
        callback.call(thisArg,this[i],i,this)
    }
}

Array.prototype.myReduce = function(callback,intialValue){
    let accumulator = intialValue
    let startIndex = 0 
    if(accumulator===undefined){
        accumulator = this[0];
        startIndex = 1
    }
    for(let i=startIndex;i<this.length;i++){
        if(i in this)
        accumulator = callback(accumulator,this[i],i,this)
    }
    return accumulator
}
const numbers = [1, 2, 3, 4];

// Using the custom reduce method with an initial value
const sum = numbers.myReduce((acc, num) => acc + num, 0);
console.log(`Sum: ${sum}`);
console.log("Try programiz.pro",ans,sum);