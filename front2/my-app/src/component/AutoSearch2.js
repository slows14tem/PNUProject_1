import React, { useState, useEffect } from "react";
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.min.css';
import Pagination from "react-js-pagination";
import Button from 'react-bootstrap/Button';
import "../style/Paging.css"
import "../style/Autosearch.css"
import { Link } from "react-router-dom";

const RestApiExample = () => {

  const selectList = ["===선택===", "machinery", "items", "part1"];
  //json 데이터 저장 state
  const [datas, setDatas] = useState();
  const [data, setData] = useState(null);
  const [list, setList] = useState(null);
  const [searchList, setSearchList] = useState(null);
  const [Selected, setSelected] = useState("");
  const [rowdata, setRowdata] = useState([]);

  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  // 중복을 제거한 machinery값을 저장하기위한 배열
  let options = [];
  const [selectedOption, setSelectedOption] = useState("");
  const [searchResults, setSearchResults] = useState([]);

  useEffect(() => {
    //
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await fetch(
          "http://10.125.121.177:8080/data/selectlist"
        );
        const json = await response.json();
        setDatas(json);
      } catch (e) {
        setError(e);
      } finally {
        setLoading(false);
      }
    };
    fetchData();

    const fetchData2 = async () => {
      setLoading(true);
      try {
        const response = await fetch(
          "http://10.125.121.177:8080/data/search"
        );
        const json = await response.json();
        setList(json);
      } catch (e) {
        setError(e);
      } finally {
        setLoading(false);
      }
    };
    fetchData2();    
  }, []);

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

  const handleChange = (event) => {
    setSelectedOption(event.target.value);
  };

  const searchData = (event) => {
    event.preventDefault();
    setSearchResults(
      options.filter((option) => option.includes(selectedOption))
    );    
  };

  useEffect(()=>{
    if (searchResults.length===1){
      if (Selected === "machinery"){setSearchList(list.filter((item)=>item.machinery.includes(searchResults)))}
      else if (Selected === "items"){setSearchList(list.filter((item)=>item.items.includes(searchResults)))}
      else {setSearchList(list.filter((item)=>item.part1.includes(searchResults)))}      
    }
    
  },[searchResults])
  console.log("leng", searchList?.length)
  

  //   options라는 배열에 중복제거한 값 저장
  for (let item in data) {
    options.push(data[item]);
  }

  // json 데이터 로딩중
  // if (loading) {
  //   return <div>Loading...</div>;
  // }
  // if (error) {
  //   return <div>Error: {error.message}</div>;
  // }
  // if (!data) {
  //   return <div>No data</div>;
  // }
  // let table2 = []

  const [page, setPage] = useState(1);
  const [count, setCount] = useState(0); //아이템 총 개수
  const [postPerPage] = useState(10); //페이지당 아이템 개수

  const [indexOfLastPost, setIndexOfLastPost] = useState(0);
  const [indexOfFirstPost, setIndexOfFirstPost] = useState(0);
  const [currentPosts, setCurrentPosts] = useState(0);

  useEffect(() => {
    setCount(searchList?.length);
    setIndexOfLastPost(page * postPerPage);
    setIndexOfFirstPost(indexOfLastPost - postPerPage);
    setCurrentPosts(searchList?.slice(indexOfFirstPost, indexOfLastPost));
  }, [page, indexOfFirstPost, indexOfLastPost, searchList, postPerPage]);

  const handlePageChange = (page) => {
    setPage(page);
  };

  const listOrder = (e) => {
    e.preventDefault()
    
  }
  

  return (
    <>
      <div className="autosearch">
      <select onChange={handleSelect}>
          {selectList.map((item) => (
            <option value={item} key={item}>
              {item}
            </option>
          ))}
        </select>
        <form onSubmit={searchData}>
          <input
            className="autoinput"
            list="options"
            value={selectedOption}
            onChange={handleChange}
          />
          <datalist id="options">
            {/* options라는 배열의 요소를 option태그 의 value 값에 넣기 */}
            {options.map((option) => (
              <option key={option} value={option} />
            ))}
          </datalist>
          {/* <button type="submit">submit</button> */}
          <Button variant="dark" className="autobutt" type="submit">Submit</Button>
          {/* 선택한 값 submit 버튼 누르면 밑에 li태그 안에 표시 */}
        </form>
      </div>
      <Table id='testTable' striped bordered hover>
      <thead>
        <tr>
          {/* <th>#</th> */}
          <th>Machinery</th>
          <th>청구품목</th>
          <th>Part.No</th>
          <th>카테고리</th>
          <th>발주처</th>
          <th>리드타임</th>
        </tr>
      </thead>
      <tbody>
        {currentPosts && searchList.length > 0 ? (
        currentPosts.map((item, index) => (
          <tr key={index} onClick={()=>setRowdata(rowdata=>[...rowdata, item])}>
            <td>{item.machinery}</td>
            <td>{item.items}</td>
            <td>{item.part1}</td>
            <td>{item.key2}</td>
            <td>{item.baljucheo}</td>
            <td>{item.leadtime}</td>
          </tr>
        )))
        : <div>검색결과가 없습니다.</div>
      }
      </tbody>
    </Table>
    <Pagination
      activePage={page} // 현재 페이지
      itemsCountPerPage={10} // 한 페이지랑 보여줄 아이템 갯수
      totalItemsCount={searchList?.length} // 총 아이템 갯수
      pageRangeDisplayed={5} // paginator의 페이지 범위
      prevPageText={"‹"} // "이전"을 나타낼 텍스트
      nextPageText={"›"} // "다음"을 나타낼 텍스트
      onChange={handlePageChange} // 페이지 변경을 핸들링하는 함수
    />
    <Table id='testTable' striped bordered hover>
      <thead>
        <tr>
          {/* <th>#</th> */}
          <th>Machinery</th>
          <th>청구품목</th>
          <th>Part.No</th>
          <th>카테고리</th>
          <th>발주처</th>
          <th>리드타임</th>
        </tr>
      </thead>
      <tbody >
        {rowdata?.map((item, index) => (
            <tr key={index}>
              <td>{item.machinery}</td>
              <td>{item.items}</td>
              <td>{item.part1}</td>
              <td>{item.key2}</td>
              <td>{item.baljucheo}</td>
              <td>{item.leadtime}</td>
            </tr>
          ))}
      </tbody>
      <Link to='/Order' state={rowdata}><Button variant="dark" className="autobutt">submit</Button></Link>
    </Table>
    </>
  );
};

export default RestApiExample;