import React, { useEffect, useState } from "react";
import SearchBar from './SearchBar';

// App.js 에 기본적으로 추가되는 코드를 정리하고 심플하게 만듦
function AutoSearch() {

  const selectList = ["machinery", "items", "part1"];
  const [Selected, setSelected] = useState("");
  const [datas, setDatas] = useState();
  const [data, setData] = useState();

  useEffect(()=>{
    getSearch()
  },[])

  const getSearch = async () => {
    let url = "http://localhost:8080/data/selectlist";

    try {
      const resp = await fetch(url);
      const data = await resp.json();
      setDatas(data)
    } catch (err) {
      console.log(err);
    }
  };
  
  const handleSelect = (e) => {
    setSelected(e.target.value);
    if (e.target.value === "machinery"){
      setData([...new Set(datas.map((item)=>item.machinery))])
    } else if (e.target.value === "items"){
      setData([...new Set(datas.map((item)=>item.items))])
    } else {
      setData([...new Set(datas.map((item)=>item.part1))])
    }
    
  };
  
  



//검색에 필요한 원천 데이타, 검색어, 결과값 
// const data = [
//     {"name":"키움증권", "code":"000000"},
//     {"name":"삼성전자", "code":"000002"},
//     {"name":"LG전자", "code":"000003"},
//     {"name":"스튜디오드래곤", "code":"000004"},
//     {"name":"영호화학", "code":"000005"},
//     {"name":"씨젠", "code":"000006"},
//     {"name":"LG화학", "code":"000007"}, 
//     {"name":"DL", "code":"000008"},
//     {"name":"오뚜기", "code":"000009"},
//   ];  
  const [keyword, setKeyword] = useState();
  const [results, setResult] = useState([]);
  
  // 필드를 업데이트 
  const updateField = (field, value, update = true) => {
    if (update) onSearch(value);
    if (field === 'keyword') {
      setKeyword(value);
    }
    if (field === 'results') {
      setResult(value);
    }
  }
  
  // 입력된 텍스트로 data 배열에서 찾아 매칭되는 결과들을 저장 
  const onSearch = text => {
    let results = data.filter(item => true === matchName(item, text));
    setResult({results});
    // console.log("Result", results)
  };

 // 검색해야할 문자열을 키워드와 비교하여 매칭이 되는지 체크 
   const matchName = (name, keyword) => {
    var keyLen = keyword.length;
    name = name.toLowerCase().substring(0, keyLen);
    if (keyword === "") return false;
    return name === keyword.toString().toLowerCase();
  };

  
  return (
    <div className="AutoSearch">
      <select onChange={handleSelect}>
          {selectList.map((item) => (
            <option value={item} key={item}>
              {item}
            </option>
          ))}
        </select>
      Search Auto Complete
      <SearchBar keyword={keyword} results={results} updateField={updateField} size='10'></SearchBar>
    </div>
  );
}

export default AutoSearch;