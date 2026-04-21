document.addEventListener('DOMContentLoaded', () => {
    const boardSizeInput = document.getElementById('board-size');
    const resetBtn = document.getElementById('reset-btn');
    const checkBtn = document.getElementById('check-btn');
    const chessboard = document.getElementById('chessboard');
    const message = document.getElementById('message');
    const successModal = document.getElementById('success-modal');
    const playAgainBtn = document.getElementById('play-again-btn');

    let n = 8;
    let board = Array.from({ length: n }, () => Array(n).fill(false));

    function createBoard() {
        chessboard.innerHTML = '';
        chessboard.style.gridTemplateColumns = `repeat(${n}, 1fr)`;
        for (let row = 0; row < n; row++) {
            for (let col = 0; col < n; col++) {
                const cell = document.createElement('div');
                cell.classList.add('cell');
                cell.classList.add((row + col) % 2 === 0 ? 'light' : 'dark');
                cell.dataset.row = row;
                cell.dataset.col = col;
                cell.addEventListener('click', toggleQueen);
                if (board[row][col]) {
                    cell.textContent = '♛';
                    cell.classList.add('queen');
                }
                chessboard.appendChild(cell);
            }
        }
    }

    function toggleQueen(event) {
        const row = parseInt(event.target.dataset.row);
        const col = parseInt(event.target.dataset.col);
        board[row][col] = !board[row][col];
        createBoard();
        message.textContent = '';
        message.className = 'message';
        hideModal();
    }

    function resetBoard() {
        board = Array.from({ length: n }, () => Array(n).fill(false));
        createBoard();
        message.textContent = '';
        message.className = 'message';
        hideModal();
    }

    function checkSolution() {
        const queens = [];
        for (let row = 0; row < n; row++) {
            for (let col = 0; col < n; col++) {
                if (board[row][col]) {
                    queens.push([row, col]);
                }
            }
        }
        if (queens.length !== n) {
            message.textContent = `You need exactly ${n} queens!`;
            message.className = 'message error';
            return;
        }
        if (isValid(queens)) {
            message.textContent = 'Congratulations! Valid solution!';
            message.className = 'message success';
            showSuccess(queens);
        } else {
            message.textContent = 'Invalid solution. Queens are attacking each other.';
            message.className = 'message error';
        }
    }

    function showSuccess(queens) {
        // Add success animation to queen cells
        const cells = chessboard.querySelectorAll('.cell');
        cells.forEach(cell => {
            const row = parseInt(cell.dataset.row);
            const col = parseInt(cell.dataset.col);
            if (board[row][col]) {
                cell.classList.add('success');
            }
        });
        // Show modal after a short delay
        setTimeout(() => {
            successModal.classList.add('show');
        }, 500);
    }

    function hideModal() {
        successModal.classList.remove('show');
        // Remove success animation
        const cells = chessboard.querySelectorAll('.cell.success');
        cells.forEach(cell => cell.classList.remove('success'));
    }

    function isValid(queens) {
        for (let i = 0; i < queens.length; i++) {
            for (let j = i + 1; j < queens.length; j++) {
                const [r1, c1] = queens[i];
                const [r2, c2] = queens[j];
                if (r1 === r2 || c1 === c2 || Math.abs(r1 - r2) === Math.abs(c1 - c2)) {
                    return false;
                }
            }
        }
        return true;
    }

    boardSizeInput.addEventListener('change', () => {
        n = parseInt(boardSizeInput.value);
        if (n < 4 || n > 12) {
            alert('Board size must be between 4 and 12');
            boardSizeInput.value = 8;
            n = 8;
        }
        resetBoard();
    });

    resetBtn.addEventListener('click', resetBoard);
    checkBtn.addEventListener('click', checkSolution);
    playAgainBtn.addEventListener('click', () => {
        resetBoard();
        // Optionally randomize N or keep same
    });

    createBoard();
});