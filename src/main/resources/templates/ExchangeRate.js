//觸發美金換台幣事件
function utn() {
    fetch ("http://localhost:8081/usd_to_ntd",{
    method : "GET"
    })

    .then (Response =>{
        if (Response.ok){
            return Response.json();
        }else{
            throw new Error('error');
        }
    })

    .then(data => {
        console.log(data);
        var exchangeRate = document.getElementById('exchangeRate');
    
        // 提取 id、date 和 usd_to_ntd 属性的值
        // var ratesWithIdAndDate = data.map(item => {
        //     return `id: ${item.id}, rate: ${item.usd_to_ntd}`;
        // });

        var ratesWithIdAndDate = data.map(item => {
            return { id: item.id, date:item.date,rate: item.usd_to_ntd };
        });
    
        // 空字串是避免html的div有內容時，會先清空再存入
        exchangeRate.innerHTML = '';

        //appendChild方法是像節點末尾再加新節點=> 左表格加新表格
        exchangeRate.appendChild(createTable1(ratesWithIdAndDate));
    })
        
    .catch(error =>{
        console.error(error);
    })
}

//呼叫createTable1自動生成表格
function createTable1(ratesWithIdAndDate) {
    var table = document.createElement("table");
  
    var headerRow = document.createElement("tr");
    var header1 = document.createElement("th");
    header1.textContent = "id";
    var header2 = document.createElement("th");
    header2.textContent = "時間";
    var header3 = document.createElement("th");
    header3.textContent = "匯率";

    headerRow.appendChild(header1);
    headerRow.appendChild(header2);
    headerRow.appendChild(header3);

    table.appendChild(headerRow);

    ratesWithIdAndDate.forEach(item => {
        var row = document.createElement("tr");
        var cell1 = document.createElement("td");
        cell1.textContent = item.id;
        var cell2 = document.createElement("td");
        cell2.textContent = item.date;
        var cell3 = document.createElement("td");
        cell3.textContent = item.rate;

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);

        table.appendChild(row);
    });

    return table;
}

//觸發人民幣轉台幣匯率事件
function rtn() {
    fetch ("http://localhost:8081/rmb_to_ntd",{
    method : "GET"
    })

    .then (Response =>{
        if (Response.ok){
            return Response.json();
        }else{
            throw new Error('error');
        }
    })

    .then(data => {
        console.log(data);
        var exchangeRate = document.getElementById('exchangeRate');
        var ratesWithIdAndDate = data.map(item => {
            return { id: item.id, date:item.date,rate: item.rmb_to_ntd };
        });
    
        // 空字串是避免html的div有內容時，會先清空再存入
        exchangeRate.innerHTML = '';

        //appendChild方法是像節點末尾再加新節點=> 左表格加新表格
        exchangeRate.appendChild(createTable1(ratesWithIdAndDate));
    })
        
    .catch(error =>{
        console.error(error);
    })
}

//觸發美金換人民幣事件
function rtu() {
    fetch ("http://localhost:8081/usd_to_rmb",{
    method : "GET"
    })

    .then (Response =>{
        if (Response.ok){
            return Response.json();
        }else{
            throw new Error('error');
        }
    })

    .then(data => {
        console.log(data);
        var exchangeRate = document.getElementById('exchangeRate');

        var ratesWithIdAndDate = data.map(item => {
            return { id: item.id, date:item.date,rate: item.usd_to_rmb };
        });
    
        // 空字串是避免html的div有內容時，會先清空再存入
        exchangeRate.innerHTML = '';

        //appendChild方法是像節點末尾再加新節點=> 左表格加新表格
        exchangeRate.appendChild(createTable1(ratesWithIdAndDate));
    })
        
    .catch(error =>{
        console.error(error);
    })
}

//刪除匯率
function del(){
    var rateId = document.getElementById('rateId').value; // 获取输入框的值
    fetch("http://localhost:8081/deleteRates/" + rateId, {
        method: "DELETE" // 使用DELETE请求    
        })
        .then (Response =>{
            if (Response.ok){
                // console.log("ok")
                // return Response.text('刪除成功');
                alert('刪除成功'); // 使用alert來顯示成功提示框
            }else{
                throw new Error('刪除失敗');
            }
        })
        // .then(data => {
        //     console.log(data); // 在控制台中输出成功消息
        // })
        .catch(error => {
            console.error(error); // 捕获并输出错误消息
        });     
}

//新增匯率
document.addEventListener('DOMContentLoaded', function () {
    const submitBtn = document.getElementById('submitBtn');
    const message = document.getElementById('message');
    submitBtn.addEventListener('click', function (event) {
        event.preventDefault();
        // 收集表單數據
        const data = {
            date: document.getElementById('date').value, // 使用日期輸入框的值
            usd_to_ntd: parseFloat(document.getElementById('usd_to_ntd').value), // 使用parseFloat將數值轉換為浮點數
            rmb_to_ntd: parseFloat(document.getElementById('rmb_to_ntd').value), // 使用parseFloat將數值轉換為浮點數
            usd_to_rmb: parseFloat(document.getElementById('usd_to_rmb').value), // 使用parseFloat將數值轉換為浮點數
        };

        fetch('http://localhost:8081/addRates', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)           
        })
        .then(response => {
            return response.text(); // 獲取控制台的文本內容
        })
        .then(textData => {
            console.log('實際JSON 數據：', textData);
            const jsonData = JSON.parse(textData); // 解析 JSON
            return jsonData;
        })
        .then(result => {
            console.log('API響應 JSON 數據：', result);
            if (result.success) {
                message.innerHTML = '匯率資料已成功新增！';
                // 清空表单
                document.getElementById('exchangeForm').reset();
            } else {
                message.innerHTML = '錯誤：' + result.message;
            }
        })
        .catch(error => {
            console.error('錯誤：', error);
            message.innerHTML = '發生錯誤，請檢查連線或稍後再試。';
        });
    });
});
