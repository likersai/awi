var sunye = {
    laugh: "haha"
}



var haha = sunye.laugh;
haha = 'yaya';
// document.writeln(sunye.laugh);
// document.writeln(haha);



if (typeof Object.beget !== 'function'){
    Object.create = function (o) {
        var F = function () {};

        F.prototype = o;
        return new F();
    }
}

var another_sunye = Object.create(sunye);
document.write(another_sunye.laugh)



function aFunction() {
    console.log(this);
    console.log(arguments);
}


aFunction("sunye","nihao");


//方法调用模式
//方法可以使用this访问自己所属的对象,this对对象的绑定发生在函数调用的时候
var myObject = {
    value : 0,
    increment : function (inc) {
        this.value += typeof inc === 'number' ? inc : 1;
    }
}

myObject.increment();
console.log(myObject.value);
myObject.increment(1000);
console.log(myObject.value);

//函数调用模式
//以此模式调用函数的时候，this被绑定到全局对象。这是语言设计上的一个错误。
var add = function (x,y) {
    return x + y;
}

var sum = add(5,6);
console.log(sum)

myObject.double = function () {
    var that = this;
    var helper = function () {
        that.value = add(that.value,that.value);
    }
    helper();
}

myObject.double();
console.log(myObject.value)

//构造器调用模式
//JavaScript是一门基于原型继承的语言
//如果在一个函数前面带上 new 来调用，那么背地里将会创建一个链接到该函数的prototype成员的新对象，同时this会被绑定在这个新对象上
//new 的前缀也会改变return 的行为
console.log("构造器调用模式");
//和一般函数没有区别，只是命名的时候首字母大写表示这个函数希望被以构造器模式调用
//会返回this-*/
//这种模式过于依赖程序员的素养，不推荐使用
var Quo = function (string) {
    this.status = string;
}

Quo.prototype.getStatus = function () {
    return this.status;
}

var myQuo = new Quo("sunye");
console.log(myQuo.getStatus());





//Apply调用模式
console.log("Apply调用模式");
//JavaScript是一门函数式的面向对象编程语言，所以函数可以拥有方法

var array = [3,4];
var sumApply = add.apply(null,array);
//apply方法让我们构建了一个参数数组传递给调用函数，它允许我们选择this 的值
//apply方法接收两个参数,第一个是要绑定给this的值,第二个是一个参数数组


//回调 
var testCallBack = function(){
    sleep(3000,function (ret) {
        console.log(new Date())
    });
}

var sleep = function (n,callback) {
    setTimeout()
    var worker = new Worker('work.js');
    var start = new Date().getTime();
    // console.log('休眠前：' + start);
    while (true) {
        if (new Date().getTime() - start > n) {
            break;
        }
    }
    callback();
    return {
        callback : 'callback'
    }
}


Function.prototype.method = function (name,func) {
    if (!this.prototype[name]){
        this.prototype[name] = func;
    }
    return this;
}

/**
 * 柯里化
 */
Function.method('curry',function () {
    var slice = Array.prototype.slice(),
        args = slice.apply(arguments),
        that = this;
    return function () {
        return that.apply(null,args.concat(slice.apply(arguments)))
    }
})

/**
 * fibonacci函数
 * @param n
 * @returns {*}
 */
var fibonacci = function (n) {
    return n < 2 ? n : fibonacci(n-1) + fibonacci(n-2);
}

var fibonacciWithMemory = function (n) {
    var fibonacciList = [0,1];
    var calculateFib = function (n) {
        var result = fibonacciList[n];
        if (typeof result !== 'number') {
            result = calculateFib(n-1) + calculateFib(n-2);
            fibonacciList[n] = result;
        }
        return result;
    };

    return calculateFib(n);
};

var fibonacciTest = function (n) {
    console.log(n)
    fibonacciWithMemory(12);
}


/**
 * 帮助构造记忆函数的函数
 */

var memoizer = function (memory, formula) {
    var functionWithMomery = function (n) {
        var result = memory[n];
        if (typeof result !== 'number'){
            result = formula (functionWithMomery, n);
            memory[n] = result;
        }
        return result;
    }
    return functionWithMomery;
}

var fibonacciBuildWithMemoizer = memoizer([0,1],function (functionWithMemory,n) {
    return functionWithMemory(n - 1 ) + functionWithMemory(n - 2);
})

var fiactorialBuildWithMemoizer = memoizer([0,1],function (functionWithMemory,n) {
    return n * functionWithMemory(n - 1);
})


/**
 * 定义一个构造器并扩充原型
 */
var Animail = function(name){
    this.name = name;
}

Animail.prototype.getName = function () {
    return this.name;
}
Animail.prototype.says = function () {
    return this.saying || '';
}
/**
 * 构造一个实例
 * @type {Animail}
 */
var aAnimail = new Animail('Tom');
var tomName = aAnimail.getName();

var Cat = function (name) {
    this.name = name;
    this.saying = 'meow';
}
Cat.prototype = new Animail();

Cat.prototype.purr = function (n) {
    var i , s = '';
    for (i = 0 ; i < n ;i++){
        if (s){
            s += '-';
        }
        s += 'r';
    }
    return s;
}
Cat.prototype.getName = function () {
    return this.says() + ' ' + this.name + ' ' + this.says()
}

var myCat = new Cat('Kity');
myCat.says();
myCat.purr();
myCat.getName();

/**
 * 基于原型的继承
 */
var animals = {
    name : 'Animals',
    getName : function () {
        return this.name;
    },
    says : function () {
        return this.saying || '';
    }
}
/**
 * 使用Object.create方法构造更多的实例
 * 可以理解为以一个对象为原型创建了一个新的对象，这个对象在原型链上的位置比他的原型更低
 * 直接构造对象是以Object为原型，那么使用Object.create则是以传入的对象为原型
 * 不做任何操作的话，新的对象和原来的对象具有同样的属性和方法，修改新的对象，不会影响他的原型链
 * 差异化继承
 * 通过定制一个新的对象，指明与所基于的对象的区别，就好像复制粘贴出一个模板，然后按需要修改模板
 */
var aCat = Object.create(animals);
aCat.name = 'Hello cat';
aCat.saying = 'meow';
