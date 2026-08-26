<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Codeforces README Generator</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            color: #222;
        }

        .container {
            max-width: 1100px;
            margin: 30px auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        .card {
            background: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.08);
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        button {
            padding: 10px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin: 5px;
            font-weight: bold;
        }

        .add {
            background: #222;
            color: white;
        }

        .generate {
            background: #2da44e;
            color: white;
        }

        .copy {
            background: #0969da;
            color: white;
        }

        .delete {
            background: #cf222e;
            color: white;
        }

        .problem {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px 0;
            border-radius: 8px;
        }

        textarea {
            width: 100%;
            height: 450px;
            padding: 15px;
            font-family: monospace;
            resize: vertical;
        }

        .stats {
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
        }

        .stat {
            background: #eee;
            padding: 15px 25px;
            border-radius: 8px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Codeforces README Generator</h1>

    <div class="card">

        <h2>Profile</h2>

        <label>Codeforces Handle</label>
        <input id="handle" value="AARYANGOSWAMI">

        <label>GitHub Repository</label>
        <input id="github" value="https://github.com/AARYANG0SWAMI/Codeforces">

    </div>


    <div class="card">

        <h2>Problems</h2>

        <div id="problems"></div>

        <button class="add" onclick="addProblem()">
            + Add Problem
        </button>

    </div>


    <div class="card">

        <h2>Preview Statistics</h2>

        <div class="stats" id="stats"></div>

    </div>


    <div class="card">

        <button class="generate" onclick="generateREADME()">
            Generate README
        </button>

        <button class="copy" onclick="copyREADME()">
            Copy Markdown
        </button>

        <h2>Generated README.md</h2>

        <textarea id="output"></textarea>

    </div>

</div>


<script>

let problems = [];


function addProblem(
    contest = "",
    index = "",
    name = "",
    rating = "",
    file = ""
) {

    const id = Date.now() + Math.random();

    problems.push({
        id,
        contest,
        index,
        name,
        rating,
        file
    });

    renderProblems();
}


function deleteProblem(id) {

    problems = problems.filter(
        problem => problem.id !== id
    );

    renderProblems();
}


function updateProblem(id, field, value) {

    const problem = problems.find(
        p => p.id === id
    );

    if (problem) {
        problem[field] = value;
    }

    updateStats();
}


function renderProblems() {

    const container =
        document.getElementById("problems");

    container.innerHTML = "";

    problems.forEach(problem => {

        const div =
            document.createElement("div");

        div.className = "problem";

        div.innerHTML = `

            <label>Contest ID</label>
            <input
                value="${problem.contest}"
                oninput="updateProblem(
                    ${problem.id},
                    'contest',
                    this.value
                )"
                placeholder="263"
            >

            <label>Index</label>
            <input
                value="${problem.index}"
                oninput="updateProblem(
                    ${problem.id},
                    'index',
                    this.value
                )"
                placeholder="A"
            >

            <label>Problem Name</label>
            <input
                value="${problem.name}"
                oninput="updateProblem(
                    ${problem.id},
                    'name',
                    this.value
                )"
                placeholder="Beautiful Matrix"
            >

            <label>Rating</label>
            <input
                type="number"
                value="${problem.rating}"
                oninput="updateProblem(
                    ${problem.id},
                    'rating',
                    this.value
                )"
                placeholder="800"
            >

            <label>Java File Path</label>
            <input
                value="${problem.file}"
                oninput="updateProblem(
                    ${problem.id},
                    'file',
                    this.value
                )"
                placeholder="263A-Beautiful-Matrix.java"
            >

            <button
                class="delete"
                onclick="deleteProblem(${problem.id})"
            >
                Delete
            </button>

        `;

        container.appendChild(div);
    });

    updateStats();
}


function updateStats() {

    const stats =
        document.getElementById("stats");

    const ratingCount = {};

    problems.forEach(problem => {

        if (!problem.rating) {
            return;
        }

        const rating =
            parseInt(problem.rating);

        ratingCount[rating] =
            (ratingCount[rating] || 0) + 1;
    });

    let html = "";

    html += `
        <div class="stat">
            <strong>Total</strong><br>
            ${problems.length}
        </div>
    `;

    Object.keys(ratingCount)
        .sort((a,b) => a-b)
        .forEach(rating => {

            html += `
                <div class="stat">
                    <strong>${rating}</strong><br>
                    ${ratingCount[rating]} solved
                </div>
            `;
        });

    stats.innerHTML = html;
}


function generateREADME() {

    const handle =
        document.getElementById("handle").value;

    const github =
        document.getElementById("github").value;

    let markdown = "";

    markdown += `# ${handle} - Codeforces Solutions\n\n`;

    markdown +=
        `My Codeforces problem-solving journey using Java.\n\n`;

    markdown += `**Codeforces:** [${handle}](https://codeforces.com/profile/${handle})  \n`;

    markdown +=
        `**GitHub:** [Repository](${github})\n\n`;


    markdown += `## 📊 Statistics\n\n`;

    markdown +=
        `**Total Problems Solved:** ${problems.length}\n\n`;


    const ratingCount = {};

    problems.forEach(problem => {

        if (!problem.rating) {
            return;
        }

        const rating =
            parseInt(problem.rating);

        ratingCount[rating] =
            (ratingCount[rating] || 0) + 1;
    });


    markdown += `| Rating | Solved |\n`;
    markdown += `|-------:|-------:|\n`;

    Object.keys(ratingCount)
        .sort((a,b) => a-b)
        .forEach(rating => {

            markdown +=
                `| ${rating} | ${ratingCount[rating]} |\n`;
        });


    markdown += `\n## 🧩 Problems\n\n`;

    markdown +=
        `| # | Problem | Rating | Solution |\n`;

    markdown +=
        `|---|---|---:|---|\n`;


    const sorted =
        [...problems].sort(
            (a,b) =>
                parseInt(a.rating || 0) -
                parseInt(b.rating || 0)
        );


    sorted.forEach(problem => {

        const number =
            `${problem.contest}${problem.index}`;

        const problemName =
            `${number} - ${problem.name}`;

        let solution = "-";

        if (problem.file) {

            solution =
                `[Java](${problem.file})`;
        }

        markdown +=
            `| ${number} | ${problem.name} | ${problem.rating} | ${solution} |\n`;
    });


    markdown += `\n`;

    markdown += `## 📚 Rating Progress\n\n`;

    markdown +=
        `| Rating | Problems |\n`;

    markdown +=
        `|-------:|---------:|\n`;

    Object.keys(ratingCount)
        .sort((a,b) => a-b)
        .forEach(rating => {

            const count =
                ratingCount[rating];

            const bar =
                "█".repeat(Math.min(count, 30));

            markdown +=
                `| ${rating} | ${bar} ${count} |\n`;
        });


    markdown += `\n---\n\n`;

    markdown +=
        `*Solutions are written and maintained by ${handle}.*\n`;


    document.getElementById("output").value =
        markdown;
}


function copyREADME() {

    const output =
        document.getElementById("output");

    output.select();

    navigator.clipboard.writeText(
        output.value
    );

    alert("README copied!");
}


// Start with your existing problems

addProblem(
    "136",
    "A",
    "Presents",
    "800",
    "Presents.java"
);

addProblem(
    "158",
    "A",
    "Next Round",
    "800",
    "NextRound.java"
);

addProblem(
    "231",
    "A",
    "Team",
    "800",
    "Team.java"
);

addProblem(
    "263",
    "A",
    "Beautiful Matrix",
    "800",
    "BeautifulMatrix.java"
);

addProblem(
    "2256",
    "B",
    "Domino Tiles",
    "",
    ""
);

</script>

</body>
</html>
