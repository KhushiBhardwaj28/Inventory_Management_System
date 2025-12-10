import React from "react";

const PaginationComponent = ({currentPage, totalPages, onPageChange}) =>{
    //Generate page numbers based on total pages
    const pageNumbers = Array.from({length: totalPages}, (_, i) => i+1);

    return(
        <div className="pagination-container" style={{ display: 'flex', gap: 8, alignItems: 'center', justifyContent: 'center', marginTop: 16 }}>
            <button 
            className="btn-ghost"
            disabled={currentPage === 1}
            onClick={()=> onPageChange(currentPage - 1)}
            >
                &laquo; Prev
            </button>

            {pageNumbers.map((number) =>(
                <button key={number}
                className={`btn-ghost ${currentPage === number ? "active": ""} ` }
                onClick={()=> onPageChange(number)}>
                {number}
                </button>
            ))}

            <button className="btn-ghost"
            disabled={currentPage === totalPages}
            onClick={()=> onPageChange(currentPage + 1)}>
                    Next &raquo;
            </button>

        </div>
    )
}
export default PaginationComponent;