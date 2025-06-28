function removeVietnameseTones(str) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();
}

function filterTable(inputId, tableBodyId, columnIndexesToSearch) {
    const keywordRaw = document.getElementById(inputId).value;
    const keyword = removeVietnameseTones(keywordRaw.trim());
    const rows = Array.from(document.querySelectorAll(`#${tableBodyId} tr`))
        .filter(row => row.id !== 'noResultsRow');

    let visibleCount = 0;

    rows.forEach(row => {
        const match = columnIndexesToSearch.some(index => {
            const cellText = row.cells[index]?.textContent || "";
            return removeVietnameseTones(cellText).includes(keyword);
        });

        if (match) {
            row.style.display = "";
            visibleCount++;
        } else {
            row.style.display = "none";
        }
    });

    const noResultRow = document.getElementById("noResultsRow");
    if (noResultRow) {
        noResultRow.style.display = visibleCount === 0 ? "" : "none";
    }
}
